#include <bits/stdc++.h>
using namespace std;
vector<int> instersection(vector<int> &v1, vector<int> &v2) {
  vector<int> v3;
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  set_intersection(v1.begin(), v1.end(), v2.begin(), v2.end(),
                   back_inserter(v3));
  return v3;
}
int main() {
  int buck_num, garden_len;
  cin >> buck_num >> garden_len;
  int tmp;
  vector<int> buckets;
  for (int i = 0; i < buck_num; i++) {
    cin >> tmp;
    buckets.push_back(tmp);
  }
  vector<int> divs;
  for (int i = 1; i <= garden_len; i++) {
    if (garden_len % i == 0) divs.push_back(i);
  }
  vector<int> res;
  res = instersection(divs, buckets);
  cout << garden_len / (*(res.end() - 1));
}
