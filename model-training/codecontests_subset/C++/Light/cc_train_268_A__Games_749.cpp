#include <bits/stdc++.h>
using namespace std;
struct team {
  int h;
  int a;
};
int main() {
  int n;
  int c = 0;
  cin >> n;
  team t[100];
  for (int i = 0; i < n; i++) {
    cin >> t[i].h;
    cin >> t[i].a;
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (t[i].a == t[j].h) {
        c++;
      }
    }
  }
  cout << c;
  return 0;
}
