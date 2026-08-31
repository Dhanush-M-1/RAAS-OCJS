var mapLength = parseInt(readline()),
    map = readline().split(""),
    jumpMax, mas = [], answer = "no";

jumpMax = parseInt(mapLength / 4); // Длина максимального прыжка

// Перебираем все возможные длины прыжка (шаг не может быть < 1)
for (var i = 1, flag = true; i <= jumpMax && flag; i+=1 ) {


    for (j = 0; j < mapLength && flag; j += 1) {
        var ans = 0;

        for (var k = j; k < mapLength; k += i) {
            if(map[k] === "*") {
                ans += 1;
            }
            else {
                ans = 0;
            }

            if(ans === 5) {
                answer = "yes";
                flag = false;
            }
        }
    }

}


write(answer);