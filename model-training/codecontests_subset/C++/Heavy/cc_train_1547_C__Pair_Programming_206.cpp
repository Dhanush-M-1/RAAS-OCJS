#include <iostream>
#include<vector>
using namespace std;

int main() {
	int t;
	cin>>t;
	while(t--){
		int k,n,m;
		cin>>k>>n>>m;
		int a[n],b[m];
		for(int i = 0;i < n;i++)
		cin>>a[i];
		for(int i = 0;i < m;i++)
		cin>>b[i];
		
		vector<int> res;
		int i=0,j=0;
		bool flag=true;
		while(i!=n || j!=m){
			if( i!=n && a[i] == 0 ){
				res.push_back(0);
				i++;
				k++;
			}else if(j != m && b[j] == 0){
				res.push_back(0);
				j++;
				k++;
			}
			else if( i!=n && a[i] <= k){
				res.push_back(a[i++]);
			}
			else if( j!= m && b[j] <= k){
				res.push_back(b[j++]);
			}
			else{
				flag=false;
				cout<<-1;
				break;
			}
		}
		if(flag){
			for(auto it: res)
			cout<<it<<" ";
		}
		cout<<endl;
	}
	return 0;
}