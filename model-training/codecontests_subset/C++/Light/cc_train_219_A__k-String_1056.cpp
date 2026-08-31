#include <bits/stdc++.h>
const int md = 1000000007;
using namespace std;
int cnt[26];
int main() {
  for (int i = 0; i < 26; i++) cnt[i] = 0;
  int k;
  scanf("%d\n", &k);
  char c;
  while ((c = getchar()) != '\n' && c != EOF) cnt[c - 'a']++;
  for (int i = 0; i < 26; i++)
    if (cnt[i] % k != 0) {
      cout << "-1" << endl;
      return 0;
    }
  for (int i = 0; i < k; i++) {
    for (int j = 0; j < 26; j++) {
      for (int z = 0; z < cnt[j] / k; z++) putchar('a' + j);
    }
  }
  putchar(10);
}
