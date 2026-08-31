#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
char qs[300];
int n;
int main(int argc, char **argv) {
  ios_base::sync_with_stdio(0);
  int index = 0;
  while (cin >> qs[index] >> qs[index] && qs[index] != '=') index++;
  cin >> n;
  int pcount = 1, mcount = 0;
  for (int i = 0; qs[i] != '='; i++) {
    pcount += qs[i] == '+';
    mcount += qs[i] == '-';
  }
  if (n > n * pcount - mcount || n < pcount - n * mcount) {
    cout << "Impossible" << endl;
    return 0;
  }
  vector<int> res(pcount + mcount, 1);
  int sum = pcount - mcount;
  int j = 0;
  while (sum < n) {
    if (res[j] < n) {
      res[j]++;
      sum++;
    } else {
      do {
        j++;
      } while (qs[j - 1] != '+');
    }
  }
  j = 0;
  do {
    j++;
  } while (qs[j - 1] != '-');
  while (sum > n) {
    if (res[j] < n) {
      res[j]++;
      sum--;
    } else {
      do {
        j++;
      } while (qs[j - 1] != '-');
    }
  }
  cout << "Possible\n";
  for (int i = 0; i < (int)(res.size()); i++) {
    cout << res[i] << " " << qs[i] << " ";
  }
  cout << n;
}
