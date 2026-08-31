#include <iostream>
using namespace std;
int main(void){

	double x1,x2,x3,x4,y1,y2,y3,y4, tmp1, tmp2, tmp3, tmp4;
	char c;
	while (cin>>x1>>c>>y1>>c>>x2>>c>>y2>>c>>x3>>c>>y3>>c>>x4>>c>>y4){
		tmp1 = (y2-y1)*(x3-x1)-(y3-y1)*(x2-x1);
		tmp2 = (y4-y1)*(x3-x1)-(y3-y1)*(x4-x1);
		
		tmp3 = (y1-y2)*(x4-x2)-(y4-y2)*(x1-x2);
		tmp4 = (y3-y2)*(x4-x2)-(y4-y2)*(x3-x2);
		if (tmp1*tmp2<0 && tmp3*tmp4<0) cout<<"YES"<<endl;
		else cout<<"NO"<<endl;
	}
	return 0;
}