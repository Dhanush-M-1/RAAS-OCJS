#include <bits/stdc++.h>
using namespace std;
char s[10005];
int a[105];
int main() {
  gets(s);
  int plus = 1, minus = 0, n;
  vector<string> signs;
  for (char *p = strtok(s, " "); p; p = strtok(NULL, " ")) {
    if (!strcmp(p, "+")) {
      plus++;
      signs.push_back(p);
    } else if (!strcmp(p, "-")) {
      minus++;
      signs.push_back(p);
    } else if (p[0] >= '1' && p[0] <= '9')
      n = stoi(p);
  }
  if (plus - minus * n <= n && plus * n - minus >= n) {
    printf("Possible\n");
    a[1] = n;
    int sum = n;
    for (int i = 0; i < signs.size(); i++) {
      a[i + 2] = signs[i] == "+" ? n : 1;
      sum += a[i + 2] * (signs[i] == "+" ? 1 : -1);
    }
    for (int i = 1; i < signs.size() + 2; i++) {
      if ((i == 1 || signs[i - 2] == "+")) {
        a[i] = max(1, a[i] - (sum - n));
        sum -= (n - a[i]);
        if (sum == n) break;
      } else {
        a[i] = min(n, a[i] + (sum - n));
        sum -= (a[i] - 1);
        if (sum == n) break;
      }
    }
    printf("%d ", a[1]);
    for (int i = 2; i < signs.size() + 2; i++) {
      printf("%s %d ", signs[i - 2].c_str(), a[i]);
    }
    printf("= %d", n);
  } else
    printf("Impossible");
  return 0;
}
