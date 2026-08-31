#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:100000000000000")
using namespace std;
const long long int INF = 1e17;
int main() {
  long long int n, x, a;
  cin >> n >> x;
  x--;
  vector<long long int> op(n, -1), an(n, -1);
  vector<long long int> ch(n, 0);
  vector<long long int> used(n, 0);
  for (long long int i = 0; i < n; i++) {
    cin >> a;
    if (!a)
      ch[i] = 1;
    else {
      a--;
      op[i] = a;
      an[a] = i;
    }
  }
  long long int num = 1;
  while (!ch[x]) {
    num++;
    x = op[x];
  }
  used[x]++;
  vector<long long int> numb;
  for (long long int i = 0; i < n; i++) {
    if (ch[i] && !used[i]) {
      used[i]++;
      long long int temp = 1;
      x = i;
      while (an[x] != -1) {
        temp++;
        x = an[x];
      }
      numb.push_back(temp);
    }
  }
  sort(numb.begin(), numb.end());
  vector<long long int> can(n + 1, 0);
  can[num] = 1;
  for (long long int i = 0; i < numb.size(); i++) {
    vector<long long int> newo = can;
    for (long long int j = 0; j <= n; j++) {
      if (can[j]) newo[j + numb[i]]++;
    }
    can = newo;
  }
  for (long long int i = 0; i <= n; i++) {
    if (can[i]) cout << i << endl;
  }
}
