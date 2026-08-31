#include <bits/stdc++.h>
using namespace std;
int n, answer, cnt, acnt;
string p;
int main() {
  cin >> n;
  cin >> p;
  answer = n;
  for (int i = 0; i < n; i++) {
    if (p[i] == 'F') {
      answer--;
    }
    if (p[i] == 'I') {
      cnt++;
    }
    if (p[i] == 'A') {
      acnt++;
    }
  }
  if (cnt >= 2) {
    cout << 0;
  }
  if (cnt == 1) {
    cout << 1;
  }
  if (cnt <= 0) {
    cout << acnt;
  }
}
