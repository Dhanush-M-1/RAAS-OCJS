#include <bits/stdc++.h>
using namespace std;
void set1(int alpha[]) {
  for (int i = 0; i < 26; i++) alpha[i] = 0;
}
void set2(int alpha[], char s[]) {
  for (int i = 0; s[i]; i++) {
    alpha[s[i] - 97]++;
  }
}
bool check(int alpha[], int k) {
  for (int i = 0; i < 26; i++) {
    if (alpha[i] % k != 0) return false;
    alpha[i] /= k;
  }
  return true;
}
void display(int alpha[]) {
  for (int i = 0; i < 26; i++) {
    for (int j = 0; j < alpha[i]; j++) {
      cout << char(i + 97);
    }
  }
}
int main() {
  int k;
  char s[1100];
  int alpha[26];
  set1(alpha);
  cin >> k;
  cin >> s;
  set2(alpha, s);
  if (check(alpha, k)) {
    for (int i = 0; i < k; i++) display(alpha);
  } else {
    cout << -1 << endl;
  }
  return 0;
}
