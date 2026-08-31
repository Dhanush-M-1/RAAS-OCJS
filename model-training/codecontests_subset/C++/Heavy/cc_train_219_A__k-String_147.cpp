#include <bits/stdc++.h>
using namespace std;
int a[1007];
int main() {
  int n, m, x, y, z = 0;
  string s, sr;
  memset(a, 0, sizeof a);
  vector<char> v;
  scanf("%d", &(n));
  cin >> s;
  for (int(i) = (0); (i) <= (s.length() - 1); (i)++) {
    a[(int)s[i] - 96]++;
  }
  for (int(i) = (1); (i) <= (26); (i)++) {
    if (a[i] % n != 0) {
      printf("%d", -1);
      break;
    } else if (a[i] % n == 0 && i == 26) {
      while (v.size() != s.length()) {
        for (int(j) = (1); (j) <= (26); (j)++) {
          for (int(k) = (1); (k) <= (a[j] / n); (k)++) {
            if (sr.length() != s.length()) v.push_back((char)j + 96);
          }
        }
      }
      for (int(i) = (0); (i) <= (v.size() - 1); (i)++) cout << v[i];
    }
  }
  return 0;
}
