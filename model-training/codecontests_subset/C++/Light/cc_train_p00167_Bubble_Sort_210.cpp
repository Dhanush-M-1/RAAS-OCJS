#include <iostream>
#include <vector>
using namespace std;
int bubble(vector<int>, vector<int>&);

int main() {
  do {
    int n;
    cin >> n;
    if(n == 0) break;
    vector<int> nums;
    for(int i = 0; i < n; ++i) {
      int buff;
      cin >> buff;
      nums.push_back(buff);
    }
    int count = 0;
    for(int i = 0; i < n - 1; ++i) {
      vector<int> result;
      count += bubble(nums, result);
      nums = result;
    }
    cout << count << endl;
  } while(true);
  return 0;
}

int bubble(vector<int> nums, vector<int> &result) {
  int size = nums.size();
  int buff = nums[0];
  int count = 0;
  for(int i = 0; i < size - 1; ++i) {
    if(buff > nums[i + 1]) ++count;
    result.push_back(min(buff, nums[i + 1]));
    buff = max(buff, nums[i + 1]);
  }
  result.push_back(buff);
  return count;
}