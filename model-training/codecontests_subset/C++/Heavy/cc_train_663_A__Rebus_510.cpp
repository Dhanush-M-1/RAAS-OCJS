#include <bits/stdc++.h>
using namespace std;
string str, tmp;
int x[110];
vector<int> pos, pos2;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  getline(cin, str);
  stringstream ss(str.substr(1));
  char a, b;
  int p = 0, sum = 1;
  x[++p] = 1;
  pos.push_back(1);
  while (ss >> a) {
    if (a == '=') break;
    ss >> b;
    if (a == '+') {
      x[++p] = 1;
      pos.push_back(p);
    } else {
      x[++p] = -1;
      pos2.push_back(p);
    }
    sum += x[p];
  }
  for (int i = str.size() - 1; i >= 0 && str[i] != ' '; i--) tmp += str[i];
  reverse(tmp.begin(), tmp.end());
  int N = atoi(tmp.c_str());
  for (int i = 0; i < (int)pos.size() && sum < N; i++) {
    sum -= x[pos[i]];
    x[pos[i]] = min(N, N - sum);
    sum += x[pos[i]];
  }
  for (int i = 0; i < (int)pos2.size() && sum > N; i++) {
    int diff = sum - N;
    sum -= x[pos2[i]];
    x[pos2[i]] = max(-N, x[pos2[i]] - diff);
    sum += x[pos2[i]];
  }
  if (sum != N) {
    cout << "Impossible\n";
  } else {
    cout << "Possible\n";
    p = 0;
    for (int i = 0; i < (int)str.size(); i++) {
      if (str[i] == '\?') {
        cout << abs(x[++p]);
      } else {
        cout << str[i];
      }
    }
    cout << '\n';
  }
  return 0;
}
