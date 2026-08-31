// 2011/01/12 Tazoe

#include <iostream>
using namespace std;

int main()
{
	while(true){
		int n;
		cin >> n;
		if(n==0)
			break;

		int num[100];
		for(int i=0; i<n; i++)
			cin >> num[i];

		int cnt = 0;
		for(int i=n-1; i>=0; i--)
			for(int j=0; j<i; j++)
				if(num[j]>num[j+1]){
					int tmp = num[j];
					num[j] = num[j+1];
					num[j+1] = tmp;
					cnt++;
				}

		cout << cnt << endl;
	}

	return 0;
}