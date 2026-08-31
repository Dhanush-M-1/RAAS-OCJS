#include <bits/stdc++.h>
using namespace std;
int main() {
  long n, k;
  bool b = true;
  char s[1000], s1[1000];
  long h = -1;
  scanf("%d\n", &k);
  scanf("%s", s);
  n = strlen(s);
  map<char, long> x;
  for (int i = 0; i < n; i++) {
    x[s[i]]++;
  }
  for (map<char, long>::iterator i = x.begin(); i != x.end(); i++) {
    if ((*i).second % k == 0) {
      for (int j = 1; j <= (*i).second / k; j++) {
        h++;
        s1[h] = (*i).first;
      }
    } else {
      b = false;
    }
  }
  if (b) {
    for (int j = 1; j <= k; j++)
      for (int i = 0; i <= h; i++) printf("%c", s1[i]);
  } else
    printf("-1");
}
