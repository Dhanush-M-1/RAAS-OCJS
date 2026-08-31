#include <bits/stdc++.h>
using namespace std;
vector<int> a;
vector<int> c;
vector<int> b;
int n;
int aux;
int r1;
int r2;
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &aux);
    a.push_back(aux);
  }
  for (int i = 0; i < n - 1; i++) {
    scanf("%d", &aux);
    b.push_back(aux);
  }
  for (int i = 0; i < n - 2; i++) {
    scanf("%d", &aux);
    c.push_back(aux);
  }
  c.push_back(1000000001);
  c.push_back(1000000001);
  b.push_back(1000000001);
  sort(a.begin(), a.end());
  sort(c.begin(), c.end());
  sort(b.begin(), b.end());
  int flag = 0;
  int i = 0;
  while (i < a.size()) {
    if (a.at(i) != c.at(i)) {
      if (b.at(i) != a.at(i)) {
        r1 = a.at(i);
        a.erase(a.begin() + i);
        i--;
      } else {
        r2 = a.at(i);
        a.erase(a.begin() + i);
        b.erase(b.begin() + i);
        i--;
      }
    }
    i++;
  }
  printf("%d\n%d\n", r1, r2);
  return 0;
}
