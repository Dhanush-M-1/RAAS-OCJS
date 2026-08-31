#include<iostream>
using namespace std;

#define turn(x1,y1,x2,y2,x3,y3) x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2)
int hantei(int ax,int ay,int bx,int by,int cx,int cy,int dx,int dy);
int main()
{
	int i;
	double xy[8];
	int ans;
	char a;
	
	for(;cin >> xy[0];)
	{
		for(i=1;i<8;i++)
			cin  >> a >> xy[i];
		
		ans=1;
		
		if(hantei(xy[0],xy[1],xy[2],xy[3],xy[4],xy[5],xy[6],xy[7])==0)
			ans=0;
		
		if(hantei(xy[2],xy[3],xy[4],xy[5],xy[6],xy[7],xy[0],xy[1])==0)
			ans=0;
		
		if(hantei(xy[4],xy[5],xy[6],xy[7],xy[0],xy[1],xy[2],xy[3])==0)
			ans=0;
		
		if(hantei(xy[6],xy[7],xy[0],xy[1],xy[2],xy[3],xy[4],xy[5])==0)
			ans=0;
		
		
		if(ans==1)
			printf("YES\n");
		else
			printf("NO\n");
	}
}

int hantei(int ax,int ay,int bx,int by,int cx,int cy,int dx,int dy)
{
	if((
		turn(ax,ay,bx,by,cx,cy)>0 &&
		turn(dx,dy,ax,ay,bx,by)>0 &&
		turn(dx,dy,bx,by,cx,cy)>0 &&
		turn(dx,dy,cx,cy,ax,ay)>0)
		||(
		turn(ax,ay,bx,by,cx,cy)<0 &&
		turn(dx,dy,ax,ay,bx,by)<0 &&
		turn(dx,dy,bx,by,cx,cy)<0 &&
		turn(dx,dy,cx,cy,ax,ay)<0)
	)
		return 0;
	else
		return 1;
}