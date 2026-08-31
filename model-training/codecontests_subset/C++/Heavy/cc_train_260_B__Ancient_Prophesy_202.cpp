#include <bits/stdc++.h>
using namespace std;
int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int ok[] = {0, 1, 3, 4, 6, 7, 8, 9};
int len;
map<string, int> m;
char in[100001];
void solve(int p) {
  if (p + 10 > len) return;
  string aux;
  for (int i = 0; i < 10; ++i) aux += in[i + p];
  bool k = 1;
  for (int i = 0; i < 8 && k; ++i) k = aux[ok[i]] <= '9' && aux[ok[i]] >= '0';
  k &= aux[2] == '-' && aux[5] == '-';
  if (k) {
    int day, month, year;
    sscanf(aux.c_str(), "%d-%d-%d", &day, &month, &year);
    if (month > 0 && month <= 12 && day > 0 && day <= days[month] &&
        year >= 2013 && year <= 2015)
      m[aux]++;
  }
  solve(p + 1);
}
int main() {
  scanf("%s", in);
  len = strlen(in);
  solve(0);
  vector<pair<int, string> > vet;
  for (typeof(m.begin()) it = m.begin(); it != m.end(); ++it)
    vet.push_back(make_pair(it->second, it->first));
  sort(vet.begin(), vet.end());
  printf("%s\n", vet[vet.size() - 1].second.c_str());
}
