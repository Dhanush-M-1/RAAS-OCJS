#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
int n;
char ch[10] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
string print(int x) {
  string a = "";
  while (x) {
    a = ch[x % n] + a;
    x /= n;
  }
  return a;
}
int main() {
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      cout << print(i * j) << ' ';
    }
    puts("");
  }
  return 0;
}
