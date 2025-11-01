// Display available courses
function showCourses() {
    fetch("http://localhost:8080/skillenroll/api/courses")
        .then(response => response.json())
        .then(courses => {
            const dataTable = document.getElementById("coursetable");
            dataTable.innerHTML = "";

            courses.forEach(course => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${course.courseId}</td>
                    <td>${course.courseName}</td>
                    <td>${course.trainer}</td>
                    <td>${course.durationInWeek}</td>
                `;
                dataTable.appendChild(row);
            });
        })
        .catch(error => console.error("Error loading courses:", error));
}

// Display enrolled students
function showEnrolledStudents() {
    fetch("http://localhost:8080/skillenroll/api/courses/enrolled")
        .then(response => response.json())
        .then(students => {
            const dataTable = document.getElementById("enrolledtable");
            dataTable.innerHTML = "";

            students.forEach(student => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${student.name}</td>
                    <td>${student.emailId}</td>
                    <td>${student.courseName}</td>
                    <td>${student.enrollDate ? student.enrollDate : 'N/A'}</td>
                    <td>
                        <button onclick="unenrollStudent('${student.name}', '${student.emailId}')">
                            Unenroll
                        </button>
                    </td>
                `;
                dataTable.appendChild(row);
            });
        })
        .catch(error => console.error("Error loading enrolled students:", error));
}

// Delete enrollment
function unenrollStudent(name, emailId) {
  Swal.fire({
    title: `Unenroll ${name}?`,
    text: "Do you really want to remove this enrollment?",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#3085d6",
    cancelButtonColor: "#d33",
    confirmButtonText: "Yes, unenroll"
  }).then((result) => {
    if (result.isConfirmed) {
      fetch(`http://localhost:8080/skillenroll/api/courses/unenroll?name=${name}&emailId=${emailId}`, {
        method: "DELETE"
      })
      .then(response => response.text())
      .then(message => {
        Swal.fire("Unenrolled!", message, "success");
        showEnrolledStudents();
      })
      .catch(() => Swal.fire("Error", "Something went wrong!", "error"));
    }
  });
}






  




