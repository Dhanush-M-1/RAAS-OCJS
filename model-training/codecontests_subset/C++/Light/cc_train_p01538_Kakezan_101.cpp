#include <cstdio>
#include <cstdlib>
#include <iostream>

using namespace std;

int main()
{
	for(int q;cin>>q;) while(q--){
		string n; cin>>n;
		int i;
		for(i=0;n.size()>1;i++){
			int x=-1;
			for(int k=1;k<n.size();k++)
				x=max(x,atoi(n.substr(0,k).c_str())*atoi(n.substr(k).c_str()));
			char buf[9]; sprintf(buf,"%d",x);
			n=buf;
		}
		cout<<i<<endl;
	}
	
	return 0;
}