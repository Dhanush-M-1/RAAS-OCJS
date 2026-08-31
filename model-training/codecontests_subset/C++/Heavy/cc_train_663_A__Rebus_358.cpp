#include <bits/stdc++.h>
using namespace std;
vector<int> V;
vector<char> V2;
vector<char> V3;
int main() {
  char z;
  int mi = 0, pi = 1;
  while (cin >> z) {
    if (z == '?')
      V3.push_back('?');
    else if (z == '+') {
      pi++;
      V2.push_back(z);
    } else if (z == '-') {
      mi++;
      V2.push_back(z);
    } else if (z == '=')
      break;
  }
  int n;
  cin >> n;
  int Min = pi - (n * mi);
  int Max = n * pi - (mi);
  if (n > Max || n < Min) {
    cout << "Impossible\n";
    return 0;
  }
  cout << "Possible\n";
  vector<int> neg;
  vector<int> pos;
  if (mi > pi) {
    int res = 0;
    while (mi--) {
      neg.push_back(1);
      res--;
    }
    int count = n - res;
    while (pi--) {
      pos.push_back(1);
      count--;
    }
    for (int i = 0; i < pos.size(); i++) {
      int x = min(n - 1, count);
      pos[i] += x;
      count -= x;
    }
  } else if (pi > mi) {
    int res = 0;
    pos.push_back(n);
    for (int i = 1; i < pi; i++) {
      pos.push_back(1);
      res++;
    }
    while (mi--) {
      neg.push_back(1);
      res--;
    }
    int count1 = pi - 1, count2 = 0;
    for (int i = 0; i < neg.size(); i++) {
      int x = min(res, n - 1);
      res -= x;
      neg[i] += x;
      count2 += neg[i];
    }
    int x = count1 - count2;
    pos[0] -= x;
  } else {
    pos.push_back(n);
    pos.push_back(2);
    for (int i = 2; i < pi; i++) {
      pos.push_back(1);
    }
    for (int i = 0; i < mi; i++) {
      neg.push_back(1);
    }
  }
  cout << pos[0];
  int c1 = 1, c2 = 0;
  for (int i = 0; i < V2.size(); i++) {
    cout << ' ' << V2[i];
    if (V2[i] == '+') {
      cout << ' ' << pos[c1];
      c1++;
    } else {
      cout << ' ' << neg[c2];
      c2++;
    }
  }
  cout << " = " << n << endl;
  return 0;
}
