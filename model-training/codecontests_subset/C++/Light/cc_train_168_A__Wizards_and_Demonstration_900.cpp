#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y, need4demon, puppets;
  cin >> n >> x >> y;
  need4demon = ceil((y / 100.0) * n);
  if (x >= need4demon)
    puppets = 0;
  else
    puppets = need4demon - x;
  cout << puppets << endl;
}
