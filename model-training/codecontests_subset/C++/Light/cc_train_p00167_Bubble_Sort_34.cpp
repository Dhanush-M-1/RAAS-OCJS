#include <iostream>
#include <vector>
#include <algorithm>

#define REP(i,k,n) for(int i=k;i<n;i++)
#define rep(i,n) for(int i=0;i<n;i++)

using namespace std;

int main()
{
	int n;
	while(cin >> n && n)
	{
		vector<int> a;
		int temp,count = 0;

		rep(i,n)
		{
			cin >> temp;
			a.push_back(temp);
		}

		rep(i,n-1)
		{
			for(int j=n-1;j>i;j--)
			{
				if(a[j] < a[j-1])
				{
					count++;
					swap(a[j],a[j-1]);
				}
			}
		}

		cout << count << endl;
	}
	return 0;
}