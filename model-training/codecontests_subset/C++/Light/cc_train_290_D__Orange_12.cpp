#include <bits/stdc++.h>
using namespace std;
string s1;
int x;
int main() {
  cin >> s1;
  scanf("%d", &x);
  for (int i = 0, len = s1.length(); i < len; i++) {
    if (s1[i] < 'a') s1[i] = s1[i] - 'A' + 'a';
    int c = s1[i];
    int tmp = c;
    if ('A' <= c && c <= 'Z')
      tmp -= 'A';
    else
      tmp -= 'a';
    if (c < x + 97) {
      putchar(tmp + 'A');
    } else
      putchar(tmp + 'a');
  }
  puts("");
  return 0;
}
