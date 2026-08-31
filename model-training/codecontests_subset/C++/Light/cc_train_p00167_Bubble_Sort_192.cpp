#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main()
{
  int n;
  while(cin >> n,n)
    {
      vector<int> vec;
      vec.resize(n);
      for(int i=0;i<n;i++)
	cin >> vec[i];

      int ans = 0;

      for(int i= vec.size()-1;i>0;i--)
	for(int j=0;j<i;j++)
	  if(vec[j+1] < vec[j])
	    ans++,swap(vec[j+1],vec[j]);

      cout << ans << endl;

    }
  return 0;
}