/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


/*
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Other/CascadeStyleSheet.css to edit this template
*/
/* 
    Created on : 2026/11/24, 12:11:00
    Author     : kai
*/


const translations = {
    en: {
        home: "Home",
        exams: "Exams",
        courses: "Courses",
        about: "About",
        login: "Login",
        register: "Register",
        heroTag: "KAIGO EXAM PREPARATION",
        heroTitle: "Prepare for Your Kaigo Career",
        heroDescription: "Practice Japanese Care Worker examinations, improve your knowledge and prepare for your future career in Japan.",
        startLearning: "Start Learning",
        exploreExams: "Explore Exams",
        dashboard: "Learning Dashboard",
        mockExams: "Mock Exams",
        mockDescription: "Practice with simulated Kaigo examination questions.",
        coursesTitle: "Courses",
        coursesDescription: "Study professional Japanese nursing care knowledge.",
        results: "My Results",
        resultsDescription: "Track your learning progress and examination results.",
        viewExams: "View Exams →",
        viewCourses: "View Courses →",
        viewResults: "View Results →",
        loginTitle: "Welcome Back",
        loginDescription: "Sign in to continue your learning journey.",
        email: "Email Address",
        password: "Password",
        remember: "Remember me",
        forgot: "Forgot password?",
        signIn: "Sign In",
        noAccount: "Don't have an account?",
        createAccount: "Create Account",
        registerTitle: "Create Your Account",
        registerDescription: "Join Kaigo Exam and start learning today.",
        fullName: "Full Name",
        confirmPassword: "Confirm Password",
        alreadyAccount: "Already have an account?",
        signUp: "Sign Up",
        language: "Language"
    },

    vi: {
        home: "Trang chủ",
        exams: "Bài thi",
        courses: "Khóa học",
        about: "Giới thiệu",
        login: "Đăng nhập",
        register: "Đăng ký",
        heroTag: "NỀN TẢNG LUYỆN THI KAIGO",
        heroTitle: "Chuẩn bị cho sự nghiệp Kaigo",
        heroDescription: "Luyện thi kiến thức chăm sóc điều dưỡng Nhật Bản, nâng cao kiến thức và chuẩn bị cho sự nghiệp tương lai tại Nhật Bản.",
        startLearning: "Bắt đầu học",
        exploreExams: "Khám phá bài thi",
        dashboard: "Bảng điều khiển học tập",
        mockExams: "Thi thử",
        mockDescription: "Luyện tập với các câu hỏi thi Kaigo mô phỏng.",
        coursesTitle: "Khóa học",
        coursesDescription: "Học kiến thức chuyên môn về chăm sóc điều dưỡng Nhật Bản.",
        results: "Kết quả của tôi",
        resultsDescription: "Theo dõi tiến độ học tập và kết quả thi.",
        viewExams: "Xem bài thi →",
        viewCourses: "Xem khóa học →",
        viewResults: "Xem kết quả →",
        loginTitle: "Chào mừng trở lại",
        loginDescription: "Đăng nhập để tiếp tục hành trình học tập.",
        email: "Địa chỉ Email",
        password: "Mật khẩu",
        remember: "Ghi nhớ đăng nhập",
        forgot: "Quên mật khẩu?",
        signIn: "Đăng nhập",
        noAccount: "Chưa có tài khoản?",
        createAccount: "Tạo tài khoản",
        registerTitle: "Tạo tài khoản của bạn",
        registerDescription: "Tham gia Kaigo Exam và bắt đầu học ngay hôm nay.",
        fullName: "Họ và tên",
        confirmPassword: "Xác nhận mật khẩu",
        alreadyAccount: "Đã có tài khoản?",
        signUp: "Đăng ký",
        language: "Ngôn ngữ"
    },

    ja: {
        home: "ホーム",
        exams: "試験",
        courses: "講座",
        about: "紹介",
        login: "ログイン",
        register: "新規登録",
        heroTag: "介護試験対策",
        heroTitle: "介護のキャリアに向けて準備しましょう",
        heroDescription: "日本の介護に関する試験対策を通じて知識を深め、日本での将来のキャリアに備えましょう。",
        startLearning: "学習を始める",
        exploreExams: "試験を見る",
        dashboard: "学習ダッシュボード",
        mockExams: "模擬試験",
        mockDescription: "介護試験の模擬問題で練習しましょう。",
        coursesTitle: "講座",
        coursesDescription: "日本の介護に関する専門知識を学びましょう。",
        results: "試験結果",
        resultsDescription: "学習の進捗状況と試験結果を確認できます。",
        viewExams: "試験を見る →",
        viewCourses: "講座を見る →",
        viewResults: "結果を見る →",
        loginTitle: "おかえりなさい",
        loginDescription: "ログインして学習を続けましょう。",
        email: "メールアドレス",
        password: "パスワード",
        remember: "ログイン状態を保持する",
        forgot: "パスワードをお忘れですか？",
        signIn: "ログイン",
        noAccount: "アカウントをお持ちでないですか？",
        createAccount: "アカウントを作成",
        registerTitle: "アカウントを作成",
        registerDescription: "Kaigo Examに参加して学習を始めましょう。",
        fullName: "氏名",
        confirmPassword: "パスワードの確認",
        alreadyAccount: "すでにアカウントをお持ちですか？",
        signUp: "新規登録",
        language: "言語"
    }
};

function setLanguage(lang) {
    if (!translations[lang]) {
        lang = "en";
    }

    localStorage.setItem("kaigoLanguage", lang);

    document.documentElement.lang = lang;

    document.querySelectorAll("[data-i18n]").forEach(element => {
        const key = element.dataset.i18n;

        if (translations[lang][key]) {
            element.textContent = translations[lang][key];
        }
    });

    document.querySelectorAll("[data-i18n-placeholder]").forEach(element => {
        const key = element.dataset.i18nPlaceholder;

        if (translations[lang][key]) {
            element.placeholder = translations[lang][key];
        }
    });

    const selector = document.getElementById("languageSelect");

    if (selector) {
        selector.value = lang;
    }
}

document.addEventListener("DOMContentLoaded", () => {
    const savedLanguage =
        localStorage.getItem("kaigoLanguage") || "en";

    setLanguage(savedLanguage);

    const selector = document.getElementById("languageSelect");

    if (selector) {
        selector.addEventListener("change", event => {
            setLanguage(event.target.value);
        });
    }
});
