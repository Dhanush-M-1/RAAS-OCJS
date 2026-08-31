#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, price;
  scanf("%d %d", &n, &price);
  vector<int> honey;
  for (int i = 0; i < n; i++) {
    int c;
    scanf("%d", &c);
    honey.push_back(c);
  }
  int answ = 0;
  for (int i = 0; i < n - 1; ++i) {
    answ = max(answ, honey[i] - honey[i + 1] - price);
  }
  printf("%d", answ);
  return 0;
}
