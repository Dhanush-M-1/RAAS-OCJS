#include <bits/stdc++.h>
using namespace std;
int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};
int k;
string convert(int x) {
  string s = "";
  while (x) s += to_string(x % k), x /= k;
  reverse(s.begin(), s.end());
  return s;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> k;
  for (int i = 1; i < k; i++)
    for (int j = 1; j < k; j++) cout << convert(i * j) << " \n"[j == k - 1];
  return 0;
}
