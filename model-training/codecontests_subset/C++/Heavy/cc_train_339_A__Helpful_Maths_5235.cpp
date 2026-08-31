#include <bits/stdc++.h>
using namespace std;
int main() {
  char ch[105];
  cin >> ch;
  int cnt1 = 0, cnt2 = 0, cnt3 = 0;
  for (int i = 0; i < strlen(ch); i = i + 2) {
    if (ch[i] == '1')
      cnt1++;
    else if (ch[i] == '2')
      cnt2++;
    else
      cnt3++;
  }
  int cnt4 = 0, sum = cnt1 + cnt2 + cnt3;
  for (int i = 0; i < cnt1; i++) {
    cout << 1;
    cnt4++;
    if (cnt4 == sum) break;
    cout << "+";
  }
  for (int i = 0; i < cnt2; i++) {
    cout << 2;
    cnt4++;
    if (cnt4 == sum) break;
    cout << "+";
  }
  for (int i = 0; i < cnt3; i++) {
    cout << 3;
    cnt4++;
    if (cnt4 == sum) break;
    cout << "+";
  }
  return 0;
}
