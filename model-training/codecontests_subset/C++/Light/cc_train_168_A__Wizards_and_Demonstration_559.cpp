#include <bits/stdc++.h>
using namespace std;
ifstream fin("input.txt");
ofstream fout("output.txt");
int main() {
  vector<int> vec;
  vector<pair<int, int> > vect;
  map<int, int> mps;
  std::ios::sync_with_stdio(false);
  int n, x, y;
  cin >> n >> x >> y;
  for (int i = 0; i <= INT_MAX; ++i) {
    float z = float(x) + float(i);
    z = z * 100;
    z /= float(n);
    if (z >= y) {
      cout << i << "\n";
      break;
    }
  }
}
