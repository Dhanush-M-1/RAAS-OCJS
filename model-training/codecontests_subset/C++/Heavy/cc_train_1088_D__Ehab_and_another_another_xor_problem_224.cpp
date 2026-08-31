#include <bits/stdc++.h>
using namespace std;
int query(int a, int b) {
  int answer;
  cout << "? " << a << " " << b << endl;
  cin >> answer;
  return answer;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int a = 0, b = 0;
  int big = query(0, 0);
  for (int i = 29; i >= 0; i--) {
    int ans1 = query(a ^ (1 << i), b);
    int ans2 = query(a, b ^ (1 << i));
    if (ans1 == ans2) {
      if (big == 1)
        a ^= (1 << i);
      else
        b ^= (1 << i);
      big = ans1;
    } else {
      if (ans2 == 1) {
        a ^= (1 << i);
        b ^= (1 << i);
      }
    }
  }
  cout << "! " << a << " " << b << endl;
}
