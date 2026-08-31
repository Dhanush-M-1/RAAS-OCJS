#include <bits/stdc++.h>
using namespace std;

int N;

void func(int n, string str, int cnt) {
  if (n == N) {
    cout << str << endl;
    return;
  }
  for (int i = 0; i <= cnt; i++) {
    char c = 'a' + i;
    if (i == cnt) func(n+1, str + c, cnt + 1);
    else func(n+1, str + c, cnt);
  }
}

int main() {
  cin >> N;
  func(1, "a", 1);
}