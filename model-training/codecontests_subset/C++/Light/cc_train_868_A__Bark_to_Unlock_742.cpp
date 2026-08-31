#include <bits/stdc++.h>
using namespace std;
int n;
char target[3];
char known[101][3];
vector<int> possible;
char buf[5];
int main() {
  scanf("%s", target);
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    scanf("%s", known[i]);
    if (known[i][0] == target[0] || known[i][0] == target[1] ||
        known[i][1] == target[0] || known[i][1] == target[1]) {
      possible.push_back(i);
    }
  }
  int size = possible.size();
  bool found = false;
  for (int i = 0; i < size; ++i) {
    for (int j = 0; j < size; ++j) {
      memcpy(buf, known[possible[i]], sizeof(char) * 2);
      memcpy(buf + 2, known[possible[j]], sizeof(char) * 2);
      if (strstr(buf, target)) {
        found = true;
        goto done;
      }
    }
  }
done:
  printf(found ? "YES\n" : "NO\n");
}
