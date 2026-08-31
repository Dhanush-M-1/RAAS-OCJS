#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main (int argc, char const* argv[])
{
	int n;
	cin >> n;
	while(n)
	{
		vector<int> ary = vector<int>(n);
		for (unsigned int i = 0; i < n; i += 1)
		{
			cin >> ary[i];
		}
		int s = 0;
		for(int i = 0;i < n;i++)
		{
			for(int j = 1;j < (n-i);j++)
			{
				if(ary[j-1] > ary[j])
				{
					int tmp = ary[j-1];
					ary[j-1] = ary[j];
					ary[j] = tmp;
					s++;
				}
			}
		}
		cout << s << endl;
		cin >> n;
	}
	return 0;
}