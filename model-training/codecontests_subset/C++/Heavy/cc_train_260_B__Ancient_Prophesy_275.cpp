#include <bits/stdc++.h>
using namespace std;
const int inf = 1000000000;
const long long linf = 1000000000000000000LL;
typedef struct {
  int dia, mes, ano;
} data;
vector<data> vetor;
string linha, str;
map<int, int> mapa;
int main() {
  cin >> linha;
  int s = linha.size();
  data d;
  for (int i = int(0); i <= int(s - 10); i++) {
    str = linha.substr(i, 10);
    if (isdigit(str[0]) && isdigit(str[1]) && !isdigit(str[2]) &&
        isdigit(str[3]) && isdigit(str[4]) && !isdigit(str[5]) &&
        isdigit(str[6]) && isdigit(str[7]) && isdigit(str[8]) &&
        isdigit(str[9])) {
      d.dia = (str[0] - '0') * 10 + str[1] - '0';
      d.mes = (str[3] - '0') * 10 + str[4] - '0';
      d.ano = (str[6] - '0') * 1000 + (str[7] - '0') * 100 +
              (str[8] - '0') * 10 + str[9] - '0';
      if (d.ano >= 2013 && d.ano <= 2015 && d.mes >= 1 && d.mes <= 12 &&
          d.dia) {
        if (d.mes == 2) {
          if (d.dia <= 28) vetor.push_back(d);
        } else if (d.mes <= 7) {
          if (d.mes % 2) {
            if (d.dia <= 31) vetor.push_back(d);
          } else if (d.dia <= 30)
            vetor.push_back(d);
        } else {
          if (d.mes % 2) {
            if (d.dia <= 30) vetor.push_back(d);
          } else if (d.dia <= 31)
            vetor.push_back(d);
        }
      }
      mapa[1000000 * d.dia + 10000 * d.mes + d.ano] = 0;
    }
  }
  s = vetor.size();
  int a, b, c;
  for (int i = 0; i < s; i++) {
    a = vetor[i].dia, b = vetor[i].mes, c = vetor[i].ano;
    mapa[1000000 * a + 10000 * b + c]++;
  }
  int m = 0;
  for (map<int, int>::iterator it = mapa.begin(); it != mapa.end(); it++)
    if ((it->second) > m) m = it->second, a = it->first;
  printf("%.2d-%.2d-%.4d\n", a / 1000000, a % 1000000 / 10000, a % 10000);
  return 0;
}
