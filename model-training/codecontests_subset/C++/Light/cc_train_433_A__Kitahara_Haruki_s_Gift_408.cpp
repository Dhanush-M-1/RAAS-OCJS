#include <bits/stdc++.h>
using namespace std;
long long t[100003];
char res[4] = {'A', 'B', 'C', 'D'};
char C[300001];
char s[100004];
int B[100004];
int main() {
  int n1 = 0;
  int n2 = 0;
  int sum = 0;
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int t;
    scanf("%d", &t);
    sum += t;
    if (t == 100)
      n1++;
    else
      n2++;
  }
  if (((sum / 100) % 2 == 0)) {
    sum /= 200;
    if (sum % 2 == 0)
      puts("YES");
    else if (n1 > 0 && (n1 % 2 == 0))
      puts("YES");
    else
      puts("NO");
  } else
    puts("NO");
  printf("%s\n", s);
  return 0;
}
