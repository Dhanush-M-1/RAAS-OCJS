#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string str;
  cin >> str;
  int a, b, temp;
  bool flag = true;
  for (int i = 0; i < n - 1; i++) {
    if (flag) {
      if (str[i + 1] < str[i]) {
        flag = false;
        a = (i + 1);
      }
    }
  }
  if (flag)
    cout << "NO";
  else {
    cout << "YES" << endl;
    cout << a << " " << a + 1;
  }
}
