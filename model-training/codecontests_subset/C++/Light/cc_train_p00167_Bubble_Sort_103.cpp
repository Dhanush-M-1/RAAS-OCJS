#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;

	while(cin >> n && n)
	{
		int data[100000]={};
		int count=0;

		for(int i=0;i<n;i++)
		{
			cin >> data[i];
		}

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				if(data[j]>data[j+1])
				{
					swap(data[j],data[j+1]);
					count++;
				}
			}
		}
		cout << count << endl;
	}

    return 0;
}