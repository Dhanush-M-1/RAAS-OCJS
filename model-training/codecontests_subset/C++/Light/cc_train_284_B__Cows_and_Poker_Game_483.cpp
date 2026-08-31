#include <bits/stdc++.h>
using namespace std;
long long INF = 10000000000000001;
int k, n, m;
char line[2 * 100009];
int main() {
  cin >> n;
  cin >> line;
  int a = 0, f = 0, I = 0;
  for (int i = 0; i < strlen(line); i++) {
    if (line[i] == 'A')
      a++;
    else if (line[i] == 'I')
      I++;
    else
      f++;
  }
  if (I > 1) {
    cout << 0 << endl;
  } else if (I == 1 && (f || a)) {
    cout << 1 << endl;
  } else {
    cout << a << endl;
  }
  return 0;
}
