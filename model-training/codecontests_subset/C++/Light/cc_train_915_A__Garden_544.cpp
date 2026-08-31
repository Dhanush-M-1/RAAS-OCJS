#include <bits/stdc++.h>
using namespace std;
int main() {
  int nbuckets, gardenlen;
  cin >> nbuckets >> gardenlen;
  int max = -1;
  int bucket;
  for (int i = 0; i < nbuckets; i++) {
    cin >> bucket;
    max = (bucket > max && gardenlen % bucket == 0) ? bucket : max;
  }
  cout << gardenlen / max << endl;
  return 0;
}
