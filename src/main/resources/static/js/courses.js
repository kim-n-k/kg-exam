/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */



document.addEventListener("DOMContentLoaded", function () {

    const filterButtons = document.querySelectorAll(".filter-btn");
    const courseCards = document.querySelectorAll(".course-card");

    filterButtons.forEach(button => {

        button.addEventListener("click", function () {

            const selectedCategory = this.dataset.filter;

            // Xóa trạng thái active của các nút
            filterButtons.forEach(btn => {
                btn.classList.remove("active");
            });

            // Đánh dấu nút đang được chọn
            this.classList.add("active");

            // Lọc khóa học
            courseCards.forEach(card => {

                const category = card.dataset.category;

                if (selectedCategory === "all" ||
                    category === selectedCategory) {

                    card.style.display = "block";

                } else {

                    card.style.display = "none";

                }

            });

        });

    });

});
