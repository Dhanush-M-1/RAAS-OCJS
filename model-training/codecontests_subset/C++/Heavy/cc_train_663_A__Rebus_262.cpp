#include <bits/stdc++.h>
using namespace std;
int xp = 0, xn = 0, n, flag = 0;
void positive(int pos[], int sum) {
  for (int i = 0; i < xp; i++) {
    if ((sum + (n - 1)) < n) {
      sum += (n - 1);
      pos[i] = n;
    } else if ((sum + (n - 1)) >= n) {
      if ((n - 1 - sum) <= n) {
        pos[i] += n - sum;
        flag = 1;
        return;
      } else {
        pos[i] = n;
        sum += n - 1;
      }
    }
  }
}
void negative(int neg[], int sum) {
  for (int i = 0; i < xn; i++) {
    if ((sum - (n - 1)) > n) {
      sum -= (n - 1);
      neg[i] = n;
    } else if ((sum - (n - 1)) <= n) {
      if ((sum - n) <= n) {
        neg[i] = 0;
        sum++;
        neg[i] = sum - n;
        flag = 1;
        return;
      } else {
        neg[i] = 0;
        sum++;
        neg[i] = n;
        sum -= n;
      }
    }
  }
}
int main() {
  char s[200];
  for (int i = 0;; i++) {
    cin >> s[i];
    if (s[i] == '=') {
      s[i + 1] = '\0';
      break;
    }
  }
  int sum = 0;
  cin >> n;
  int t = 0;
  for (int i = 0; s[i] != '\0'; i++) {
    t++;
  }
  for (int i = 0; i < t; i++) {
    if (s[i] == '+') xp++;
    if (s[i] == '-') xn++;
  }
  xp++;
  int pos[xp], neg[xn];
  for (int i = 0; i < xp; i++) {
    pos[i] = 1;
    sum++;
  }
  for (int i = 0; i < xn; i++) {
    neg[i] = 1;
    sum--;
  }
  if (sum == n) flag = 1;
  if (sum < n) {
    positive(pos, sum);
  } else if (sum > n) {
    negative(neg, sum);
  }
  if (flag == 1) {
    int st = 1, nt = 0;
    cout << "Possible" << endl;
    cout << pos[0] << " ";
    for (int i = 1; i < t; i++) {
      if (s[i] == '?') {
        if (s[i - 1] == '+') {
          cout << pos[st] << " ";
          st++;
        }
        if (s[i - 1] == '-') {
          cout << neg[nt] << " ";
          nt++;
        }
      } else
        cout << s[i] << " ";
    }
    cout << n;
  } else
    cout << "Impossible";
  return 0;
}
