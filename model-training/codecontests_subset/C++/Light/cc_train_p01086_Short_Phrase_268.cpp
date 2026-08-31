#include <bits/stdc++.h>
using namespace std;

int d[] = {5,7,5,7,7};
signed
main(){
	int n;
	while(cin >> n && n!=0)
	{
			vector<int> w(n);
			for(int i=0;i<n;i++)
			{
					string s;
					cin >> s;
					w[i] = (int)s.size();
			}

			for(int i=0;i<n;i++)
			{
					int a[5] = {};
					int key = 0;
					bool flag = true;
					for(int j=i;j<n;j++)
					{
							if(key == 5){
									break;
							}
							a[key] += w[j];
							if(a[key] == d[key]){
									key++;
							}else if(a[key] < d[key]){

							}else if(a[key] > d[key]){
									flag = false;
									break;
							}
					}

					if(flag){
							cout << i+1 << endl;
							break;
					}
			}
	}
}
