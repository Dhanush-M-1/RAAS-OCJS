#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main (){
	int n;
	while(cin>>n && n){
		vector<int> v(n);
		for(int i=0;i<n;i++){
			string s;
			cin>>s;
			v[i]=s.size();
		}

		for(int i=0;i<n;i++){
			int count=0;
			int j=i;
			vector<bool> ok(5,false); 
			while(j<=n-1){
				count+=v[j];
				j++;
				if(count==5)ok[0]=true;
				if(ok[0] && count==12)ok[1]=true;
				if(ok[1] && count==17)ok[2]=true;
				if(ok[2] && count==24)ok[3]=true;
				if(ok[3] && count==31)ok[4]=true;
				if(ok[4]){
					cout<<i+1<<endl;
					goto END;
				}
			}
		}
		END:;
	}
}
