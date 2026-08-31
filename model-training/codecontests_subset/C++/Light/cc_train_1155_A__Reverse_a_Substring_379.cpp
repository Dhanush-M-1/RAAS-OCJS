#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n;
  scanf("%lld", &n);
  char str[n];
  scanf("%s", str);
  unordered_map<char, long long int> make_pair;
  make_pair[str[0]] = 1;
  for (long long int i = 1; i < n; ++i) {
    for (char c = str[i] + 1; c <= 'z'; c++) {
      if (make_pair.find(c) != make_pair.end()) {
        printf("%s", "YES\n");
        printf("%lld", make_pair[c]);
        printf("%s", " ");
        printf("%lld", i + 1);
        printf("\n");
        return 0;
      }
    }
    make_pair[str[i]] = i + 1;
  }
  printf("%s", "NO\n");
  return 0;
}
