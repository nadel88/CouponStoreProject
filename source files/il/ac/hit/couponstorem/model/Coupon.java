package il.ac.hit.couponstorem.model;
/**
 * This class implements a coupon with properties such as id , business id , details , category and price .
 * @author nadav Eliyahu.
 *
 */
public class Coupon  {
	
	//private members
	/**
	 * The business_id is the identifier of the business of which the coupon belongs to .
	 */
	private String business_id;
	//private int business_id;
	/**
	 * The details is a string that describe the coupon. 
	 */
	private String details;
	/**
	 * The image is a string URL (destination) for the image of the coupon.
	 */
	private String image;
	/**
	 * The id  is a unique identifier for a single coupon.
	 */
	private int id;
	/**
	 * The category is a string that describe the category for which the coupon belongs to.
	 */
	private String category;
	/**
	 * The price is a double variable that describe the price of the coupon.
	 */
	private double price;
	
	/**
	 * The expierdate is a string that describe the when the coupon sould be removed from the cart.
	 */
	private String expiredate ;
	
	
	
	private boolean isAvailable;
	
	
	
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	//default constructor 
	/**
	 * This is a defualt constructor for COUPON class.
	 */
	public Coupon() {
		super();
		setAvailable(true);
	}

	//custom constructor with parameters
	/**
	 * This is a constructor with parameters id,business id,image,details,category and price for coupon class.
	 * @param id the id is a unique identifier for a single coupon.
	 * @param bid the bid is the business identifier of the coupon.
	 * @param img the img is a string URL (destination) for the image of the coupon.
	 * @param det the det is a string that describe the coupon. 
	 * @param cat the cat is a string that describe the category for which the coupon belongs to.
	 * @param price the price is a double variable that describe the price of the coupon.
	 */
	public Coupon(int id,String bid, String img, String det , String cat , double price , String exp) {
		
		super();
		setId(id);
		setBusiness_id(bid);
		setImage(img);
		setDetails(det);
		setCategory(cat);
		setPrice(price);
		setExpiredate(exp);
		setAvailable(true);
	}
	
	
	//set and get methods for private members
	/**
	 * This method returns the category for which the coupon belongs to.
	 * @return this coupon category.
	 */
	public String getCategory()
	{
		return category;
	}
	
	/**
	 * This method sets the category for which the coupon belongs to.
	 * @param cat the cat is a string that describe the category for which the coupon belongs to.
	 */
	public void setCategory(String cat)
	{
		if(cat!=null)
			this.category = cat;
	}
	
	/**
	 * This method returns the business id for which the coupon belongs to.
	 * @return this coupon business id.
	 */
	public String getBusiness_id() {
		return business_id;
	}
	
	/**
	 *  This method sets the business id for which the coupon belongs to.
	 * @param business_id the business_id is the business identifier of the coupon.
	 */
	public void setBusiness_id(String business_id) {
		if(business_id != null)
			this.business_id = business_id;
	}
	
	/**
	 * This method returns the details for the coupon.
	 * @return this coupon details
	 */
	public String getDetails() {
		return details;
	}
	
	/**
	 * This method sets the details for the coupon.
	 * @param details the details is a string that describe the coupon. 
	 */
	public void setDetails(String details) {
		if(details != null)
			this.details = details;
	}
	
	/**
	 * This method returns the image URL of the coupon.
	 * @return this coupon image URL.
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * This method sets the image URL of the coupon.
	 * @param image the image is a string URL (destination) for the image of the coupon.
	 */
	public void setImage(String image) {
		if(image!=null)
			this.image = image;
	}
	
	/**
	 * This method returns the id of the coupon.
	 * @return this coupon id.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * This method sets the id of the coupon.
	 * @param id the id  is a unique identifier for a single coupon.
	 */
	public void setId(int id) {
		if(id > 0)
			this.id = id;
	}
	
	/**
	 * This method returns the price of the coupon.
	 * @return this coupon price.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * This method sets the price of the coupon
	 * @param price the price is a double variable that describe the price of the coupon.
	 */
	public void setPrice(double price) {
		if(price > 0 )
			this.price=price;
	}
	
	/**
	 * This method returns the expire date of the coupon
	 * @return this coupon expire date.
	 */
	public String getExpiredate() {
		return expiredate;
	}

	/**
	 * This method sets the expire date for the coupon.
	 * @param expierdate the expiredate is a string that describe the coupon expire date.
	 */
	public void setExpiredate(String expierdate) {
			this.expiredate = expierdate;
	}
	
	
	
	/**
	 * This method is an Override method that show the properties of the coupon.
	 */
	@Override
	//for log purposes only
	public String toString() {
		return "[" + id + ", " + business_id + ", " + "image" + ", " + details
				+","+ category +","+ price + "]";
	}
	
	//main function to test the functionality of this class through Dao class associated
	public static void main(String[] args) throws MyException {
		Coupon c = (Coupon) CouponDao.getInstance().getCoupon(2);
		System.out.println(c.toString());
	}

	

}