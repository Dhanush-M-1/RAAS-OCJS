#include <bits/stdc++.h>
using namespace std;
char moji[26] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
char moji2[26] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                  'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
char moji3[10] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
int main() {
  long long ruijou[65];
  ruijou[0] = 1;
  for (int i = 0; i < 30; i++) ruijou[i + 1] = 2 * ruijou[i];
  long long a = 0, b = 0;
  cout << "? 0 0" << endl;
  fflush(stdout);
  int flag;
  cin >> flag;
  int keta = 29;
  while (keta >= 0) {
    int tmp_a, tmp_b;
    int ans1, ans2;
    printf("? %lld %lld\n", a + ruijou[keta], b);
    fflush(stdout);
    cin >> ans1;
    printf("? %lld %lld\n", a, ruijou[keta] + b);
    fflush(stdout);
    cin >> ans2;
    if (flag == -1) {
      if (ans1 == -1 and ans2 == -1) {
        tmp_a = 0;
        tmp_b = 1;
      } else if (ans1 == -1 and ans2 == 1) {
        tmp_a = 1;
        tmp_b = 1;
      } else if (ans1 == 1 and ans2 == -1) {
        tmp_a = 0;
        tmp_b = 0;
      } else if (ans1 == 1 and ans2 == 1) {
        tmp_a = 0;
        tmp_b = 1;
      } else {
        if (flag == 1)
          a += ruijou[keta];
        else
          b += ruijou[keta];
        flag = 0;
        break;
      }
      a += tmp_a * ruijou[keta];
      b += tmp_b * ruijou[keta];
      if (ans1 == 1 and ans2 == 1) flag *= -1;
      keta -= 1;
    } else {
      if (ans1 == -1 and ans2 == -1) {
        tmp_a = 1;
        tmp_b = 0;
      } else if (ans1 == -1 and ans2 == 1) {
        tmp_a = 1;
        tmp_b = 1;
      } else if (ans1 == 1 and ans2 == -1) {
        tmp_a = 0;
        tmp_b = 0;
      } else if (ans1 == 1 and ans2 == 1) {
        tmp_a = 1;
        tmp_b = 0;
      } else {
        if (flag == 1)
          a += ruijou[keta];
        else
          b += ruijou[keta];
        flag = 0;
        break;
      }
      a += tmp_a * ruijou[keta];
      b += tmp_b * ruijou[keta];
      if (ans1 == -1 and ans2 == -1) flag *= -1;
      keta -= 1;
    }
  }
  if (flag == 0 and keta > 0) {
    while (keta > 0) {
      keta -= 1;
      printf("? %lld %lld\n", a + ruijou[keta], b);
      fflush(stdout);
      int ans1;
      cin >> ans1;
      if (ans1 == 1)
        continue;
      else {
        a += ruijou[keta];
        b += ruijou[keta];
      }
    }
  }
  printf("! %lld %lld\n", a, b);
}
