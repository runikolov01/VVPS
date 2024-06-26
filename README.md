Изпит по ВВПС
Част - Самостоятелен проект

Изисквания:

За изпълнението на проекта е необходимо да се извършат следните дейности:

1. Преди имплементиране на задачата се създават:
a. матрица за проследяване на изискванията (Requirements Traceability
Matrix);
b. списък на основните конвенции при програмирането;
c. контролен списък за проверка на кода;
2. По време на имплантирането на задачата се пишат и изпълняват:
a. статично тестване – използва се създадения контролен списък за проверка
на кода (доклад от статичен анализ на кода);
b. граф на потока на управление (Control flow graphs), тестови случаи и
коментирате входните данни за Statement coverage (SC), Decision coverage
(DC) и Condition coverage (CC);
c. модулно (unit) тестване – автоматизирано чрез инструмент от средата за
разработка (мин 5).
3. След имплементиране на задачата се изпълнява функционално тестване, което
включва:
a. описание на Features чрез синтаксиса на Gherkin;
b. описание и изпълнение на Test Case с помощта на техниката разделяне на
еквивалентни дялове (Equivalence Class Partitioning);
c. Описание и изпълнение на Test Case с помощта на техниката таблица с
решения (Decision Table).

Курсовият проект се предава в архив, който е наименуван с името и факултетния
номер на студента и съдържа:
 файлове, които съдържат описание и резултати по горните точки, като всеки файл
се именува със съответния номер от изпълнената точка от заданието, напр. 1a, 1b,
1c, 2a и т.н.;
 архив с проекта – програмен код без библиотеки;
 readme файл, който описва имената, факултетния номер и групата на студента и
езика, на който е реализиран.
Идивидуалната защита на задачата е задължителна.


Задача:
Напишете програма за изчисляване на множествена регресия за анализиране на
влиянието на две или повече независими променливи върху една зависима променлива
без използване на библиотеки за тази функционалност.
Историческите данни се четат от файл.
Програмата изисква да се въведе от потребителя броя на независимите променливи и
пътя до файла с данните.

1. Използвайте следната формула за множествена регресия за изчисляване на
стойността:
β0 + Wkβ1 + Xkβ2 + Ykβ3

•	β0 е константата (интерсепт)
•	wk, xk, yk са стойностите на независимите променливи за конкретната наблюдение
•	β1, β2, β3 са коефициентите на множествената регресия за съответните независими променливи


2. Намерете β параметри чрез решаване на следните системи от линейни уравнения:
Системата от уравнения е:
β0n + β1∑n, i=1 wi + β2∑n, i=1 xi + β3∑n, i=1 yi = ∑n, i=1 zi
β0∑n, i=1 wi +β1∑n, i=1 wi^2 + β2∑n, i=1 wixi + β3∑n, i=1 wiyi = ∑n, i=1 wizi
β0∑n, i=1 xi +β1∑n, i=1 wixi + β2∑n, i=1 xi^2 + β3∑n, i=1 xiyi = ∑n, i=1 xizi
β0∑n, i=1 yi +β1∑n, i=1 wiyi + β2∑n, i=1 xiyi + β3∑n, i=1 yi^2 = ∑n, i=1 yizi


3. Решаването на тези уравнения да се осъществи чрез метода на Гаус

