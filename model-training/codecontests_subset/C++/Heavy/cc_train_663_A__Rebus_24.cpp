#include <bits/stdc++.h>
using namespace std;
string str1, str2;
char ch[100010];
int op[100010];
int main() {
  gets(ch);
  int N = strlen(ch);
  int k = 0;
  int n;
  for (int i = 0; i < N; i += 2) {
    if (ch[i] == '?') {
    } else if (ch[i] == '+') {
      op[k++] = 1;
    } else if (ch[i] == '-') {
      op[k++] = -1;
    } else if (ch[i] == '=') {
      n = 0;
      for (int j = i + 2; j < N; j++) {
        n *= 10;
        n += ch[j] - '0';
      }
    }
  }
  int sum = n, un = 1;
  for (int i = 0; i < k; i++) {
    if (op[i] > 0) {
      sum += n;
      un += 1;
    } else {
      sum -= 1;
      un -= n;
    }
  }
  if (sum >= n && un <= n) {
    printf("Possible\n");
    int a = n;
    int b = 1;
    for (int i = 0; i < k; i++) {
      if (op[i] < 0)
        a++;
      else
        b++;
    }
    int d = k + 1 - b;
    int c = d;
    if (a < b) {
      c += b - a;
      a = b;
    }
    printf("%d ", a / b);
    a -= a / b;
    b--;
    for (int i = 0; i < k; i++) {
      if (op[i] > 0) {
        printf("+ ");
        printf("%d ", a / b);
        a -= a / b;
        b--;
      } else {
        printf("- ");
        printf("%d ", c / d);
        c -= c / d;
        d--;
      }
    }
    printf("= %d\n", n);
  } else
    printf("Impossible\n");
  return 0;
}
