#include <cstdio>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
  int Q;
  scanf("%d", &Q);
  for (int i=0;i<Q;i++) {
    int N;
    scanf("%d", &N);
    bool loop = false;
    vector<int> n;
    n.push_back(N);
    while (N/10 > 0) {
      const string sN = to_string(N);
      N = 0;
      for (int j=1;j<sN.size();j++)
        N = max(N, stoi(sN.substr(0,j))*stoi(sN.substr(j)));
      if (find(n.begin(), n.end(), N) != n.end()) {
        loop = true;
        break;
      }
      n.push_back(N);
    }
    if (loop) puts("-1");
    else printf("%d\n", (int)n.size()-1);
  }
  return 0;
}