#include <bits/stdc++.h>
using namespace std;
string in;
map<string, int> m;
int meses[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int main(int argc, char *argv[]) {
  cin >> in;
  for (int i = 2; i < in.size() - 7; ++i) {
    if (in[i] == '-') {
      string date(in.c_str() + i - 2, 10);
      int contador = 0;
      for (int j = 0; j < date.size(); ++j)
        if (date[j] == '-') contador++;
      if (date[2] == '-' && date[5] == '-' && date[0] != '-' && contador == 2) {
        m[date]++;
        date.clear();
      }
    }
  }
  int maior = -1;
  string in;
  for (map<string, int>::iterator it = m.begin(); it != m.end(); ++it) {
    int day, month, year;
    sscanf((*it).first.c_str(), "%d-", &day);
    sscanf((*it).first.c_str() + 3, "%d-", &month);
    sscanf((*it).first.c_str() + 6, "%d", &year);
    if ((*it).second > maior && year >= 2013 && year <= 2015)
      if (day >= 1 && month >= 1 && month <= 12 && day <= meses[month - 1]) {
        maior = (*it).second;
        in = (*it).first;
      }
  }
  cout << in << endl;
  return 0;
}
