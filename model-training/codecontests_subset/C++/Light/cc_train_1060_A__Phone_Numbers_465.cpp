#include <bits/stdc++.h>
using namespace std;
using i64 = long long int;
using ii = pair<int, int>;
using ii64 = pair<i64, i64>;
int main() {
  int n;
  scanf("%d", &n);
  string s;
  cin >> s;
  int maxPhone = n / 11;
  int eight = 0;
  for (auto& c : s)
    if (c == '8') eight++;
  printf("%d\n", min(maxPhone, eight));
  return 0;
}
